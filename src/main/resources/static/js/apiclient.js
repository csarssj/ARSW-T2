apiclient= (function () {
            var url = "https://parcialweather-2.herokuapp.com/weather"
            var  getWeatherByCity = function(city,callback){
                $.getJSON(url+"/"+city,(data)=>{
                    callback(data);
                },null)
            };
            var  getFunctionsByCinemaAndDateAndMovie = function(cine,cinema_date,cinema_movie,callback){
               $.getJSON(url+"/"+cine+"/"+cinema_date+"/"+cinema_movie,(data)=>{
                   callback(data);
               },null)
            };
            return {
                getWeatherByCity:getWeatherByCity,
                getFunctionsByCinemaAndDateAndMovie:getFunctionsByCinemaAndDateAndMovie,
            }

 })();