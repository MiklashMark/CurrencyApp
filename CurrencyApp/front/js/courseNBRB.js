var apiUrl = "http://localhost:8080/nbrbRate"; // URL 
var getDataButton = document.getElementById("getDataButton");
var dateInput = document.getElementById("dateInput");
var tableBody = document.getElementById("currencyTableBody");

function getData() {
    var selectedDate = dateInput.value;

    var url = apiUrl;
    if (selectedDate) {
        url += "/date?date=" + selectedDate;
    }

    fetch(url)
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            tableBody.innerHTML = ""; // Очищаем таблицу перед добавлением новых данных

            for (var i = 0; i < data.length; i++) {
                var row = document.createElement("tr");

                var codeCell = document.createElement("td");
                codeCell.textContent = data[i].Cur_Abbreviation;
                row.appendChild(codeCell);

                var dateCell = document.createElement("td");
                dateCell.textContent = data[i].Date;
                row.appendChild(dateCell);

                var nameCell = document.createElement("td");
                nameCell.textContent = data[i].Cur_Name;
                row.appendChild(nameCell);

                var rateCell = document.createElement("td");
                rateCell.textContent = data[i].Cur_OfficialRate;
                row.appendChild(rateCell);

                tableBody.appendChild(row);
            }
        })
        .catch(function(error) {
            console.log("Ошибка при получении данных:", error);
        });
}

getData();

dateInput.addEventListener("input", getData);
getDataButton.addEventListener("click", getData);

var dateInput = document.getElementById("dateInput");

dateInput.addEventListener("input", function() {
    var input = this.value;

    // Удаление всех символов, кроме цифр
    input = input.replace(/\D/g, "");

    // Добавление дефисов
    if (input.length > 4) {
        input = input.slice(0, 4) + "-" + input.slice(4);
    }
    if (input.length > 7) {
        input = input.slice(0, 7) + "-" + input.slice(7);
    }

    // Ограничение количества вводимых символов
    var maxLength = parseInt(this.getAttribute("maxlength"));
    if (input.length > maxLength) {
        input = input.slice(0, maxLength);
    }

    this.value = input;
});

function handleMouseWheel(event) {
  
  if (event.ctrlKey) {
    event.preventDefault();
  }
}


window.addEventListener('wheel', handleMouseWheel, { passive: false });