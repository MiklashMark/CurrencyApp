// // Данные для графика
// var data = [
//     {"Cur_ID":431,"Date":"2021-07-09T00:00:00","Cur_OfficialRate":2.5921},
//     {"Cur_ID":431,"Date":"2021-07-10T00:00:00","Cur_OfficialRate":2.5743},
//     {"Cur_ID":431,"Date":"2021-07-11T00:00:00","Cur_OfficialRate":2.5743},
//     {"Cur_ID":431,"Date":"2021-07-12T00:00:00","Cur_OfficialRate":2.5743},
//     {"Cur_ID":431,"Date":"2021-07-13T00:00:00","Cur_OfficialRate":2.5704},
//     {"Cur_ID":431,"Date":"2021-07-14T00:00:00","Cur_OfficialRate":2.5663},
//     {"Cur_ID":431,"Date":"2021-07-15T00:00:00","Cur_OfficialRate":2.5613},
//     {"Cur_ID":431,"Date":"2021-07-16T00:00:00","Cur_OfficialRate":2.5442},
//     {"Cur_ID":431,"Date":"2021-07-17T00:00:00","Cur_OfficialRate":2.5338},
//     {"Cur_ID":431,"Date":"2021-07-18T00:00:00","Cur_OfficialRate":2.5338},
//     {"Cur_ID":431,"Date":"2021-07-19T00:00:00","Cur_OfficialRate":2.5338},
//     {"Cur_ID":431,"Date":"2021-07-20T00:00:00","Cur_OfficialRate":2.5359},
//     {"Cur_ID":431,"Date":"2021-07-21T00:00:00","Cur_OfficialRate":2.5348},
//     {"Cur_ID":431,"Date":"2021-07-22T00:00:00","Cur_OfficialRate":2.5327},
//     {"Cur_ID":431,"Date":"2021-07-23T00:00:00","Cur_OfficialRate":2.5148},
//     {"Cur_ID":431,"Date":"2021-07-24T00:00:00","Cur_OfficialRate":2.5136},
//     {"Cur_ID":431,"Date":"2021-07-25T00:00:00","Cur_OfficialRate":2.5136},
//     {"Cur_ID":431,"Date":"2021-07-26T00:00:00","Cur_OfficialRate":2.5136},
//     {"Cur_ID":431,"Date":"2021-07-27T00:00:00","Cur_OfficialRate":2.5196},
//     {"Cur_ID":431,"Date":"2021-07-28T00:00:00","Cur_OfficialRate":2.5224},
//     {"Cur_ID":431,"Date":"2021-07-29T00:00:00","Cur_OfficialRate":2.5216},
//     {"Cur_ID":431,"Date":"2021-07-30T00:00:00","Cur_OfficialRate":2.5105},
//     {"Cur_ID":431,"Date":"2021-07-31T00:00:00","Cur_OfficialRate":2.4997}
// ];

function getCurrentDate() {
  const currentDate = new Date();
  const year = currentDate.getFullYear();
  const month = String(currentDate.getMonth() + 1).padStart(2, '0');
  const day = String(currentDate.getDate()).padStart(2, '0');
  return `${year}-${month}-${day}`;
}

// Получаем значения startDate и endDate из URL-параметров или используем значения по умолчанию
const urlParams = new URLSearchParams(window.location.search);
const endDate = urlParams.get('endDate') || getCurrentDate();
const endDateObj = new Date(endDate);
endDateObj.setDate(endDateObj.getDate() - 7);
const startDate = urlParams.get('startDate') || endDateObj.toISOString().slice(0, 10);



// Функция для обновления URL с новыми значениями startDate и endDate
function updateURLParams(startDate, endDate) {
  const params = new URLSearchParams(window.location.search);
  params.set('startDate', startDate);
  params.set('endDate', endDate);
  const newURL = window.location.pathname + '?' + params.toString();
  window.history.replaceState({}, '', newURL);
}


function buildChart(data) {
  // Парсинг дат и курсов валют
  var dates = data.map(function (item) {
    return new Date(item.Date);
  });

  var rates = data.map(function (item) {
    return item.Cur_OfficialRate;
  });

  // Создание графика
  var canvas = document.createElement("canvas");
  canvas.width = 600;
  canvas.height = 400;
  var ctx = canvas.getContext("2d");

  // Отрисовка осей
  ctx.beginPath();
  ctx.moveTo(50, 20);
  ctx.lineTo(50, 380);
  ctx.lineTo(570, 380);
  ctx.stroke();

  // Отрисовка меток на осях
  ctx.font = "14px Arial";
  ctx.textAlign = "center";
  ctx.fillText("Дата", 310, 400);
  ctx.fillText("Курс", 25, 200);

  // Отрисовка точек и соединяющих их линий
  ctx.beginPath();
  ctx.strokeStyle = "blue";
  ctx.lineWidth = 2;
  for (var i = 0; i < dates.length; i++) {
    var x = 50 + (i * (520 / (dates.length - 1)));
    var y = 380 - ((rates[i] - 2.4) * (320 / 0.3));
    ctx.lineTo(x, y);
    ctx.stroke();
    ctx.beginPath();
    ctx.arc(x, y, 3, 0, 2 * Math.PI);
    ctx.fill();
    ctx.beginPath();
    ctx.moveTo(x, y);
  }
  ctx.stroke();

  // Вставка графика 
  var chartDiv = document.getElementById("chart");
  chartDiv.appendChild(canvas);
}


// Отправляем запрос на сервер и получаем данные
document.getElementById('dateForm').addEventListener('submit', function(event) {
  var startDate = new Date(document.getElementById('startDate').value);
  var endDate = new Date(document.getElementById('endDate').value);

  if (startDate > endDate) {
    alert('Ошибка: Начальная дата должна быть меньше или равна конечной дате.');
    event.preventDefault(); // Отменить отправку
  }
});
fetch(`http://localhost:8080/currencyChart/period?startDate=${startDate}&endDate=${endDate}`)
    .then(response => response.json())
    .then(data => { 
    buildChart(data);
    // Обновляем URL с полученными значениями startDate и endDate
    // getCurrentDate()
    updateURLParams(startDate, endDate);
    })
    .catch(error => {
    onsole.error('Error:', error);
    });


function handleMouseWheel(event) {
  
  if (event.ctrlKey) {
    event.preventDefault();
  }
}


window.addEventListener('wheel', handleMouseWheel, { passive: false });
