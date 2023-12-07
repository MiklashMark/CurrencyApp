$(document).ready(function() {
    $('#converterForm').submit(function(event) {
        event.preventDefault();

        var firstValue = $('#firstValue').val();
        var firstCurrency = $('#firstCurrency').val();
        var secondCurrency = $('#secondCurrency').val();

        if (firstCurrency === secondCurrency) {
            alert('Пожалуйста, выберите разные валюты.');
            return;
        }

        var url = 'http://localhost:8080/converter?' +
                  'firstvalue=' + encodeURIComponent(firstValue) +
                  '&fisrtCur=' + encodeURIComponent(firstCurrency) +
                  '&SecondCur=' + encodeURIComponent(secondCurrency);


        $.ajax({
            url: url,
            method: 'GET',
            success: function(result) {
                var convertedValue = parseFloat(result);
                $('#result').text(convertedValue.toFixed(2));

                
            },
            error: function() {
                $('#result').text('Произошла ошибка при выполнении запроса.');
            }
        });
    });
});

function handleMouseWheel(event) {
  
  if (event.ctrlKey) {
    event.preventDefault();
  }
}


window.addEventListener('wheel', handleMouseWheel, { passive: false });