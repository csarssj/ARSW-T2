//var api = apimock;
var api = apiclient;
var app = (function (){
	var city;
	var _map = function (list){
    	return list.map(function(data){
    			return {name:data.name, temp:data.main.temp, pressure: data.main.pressure}
    	})
    }
	var setCity = function(city_name){
		city = city_name;
	};

	function table(weather) {
	    console.log(weather)
	    console.log(weather.main.temp);
	    console.log(weather.main.temp_min);
	    console.log(weather.main.temp_max);
	    console.log(weather.main.humidity);
	    console.log(weather.main.pressure);
	    console.log(weather.main.feels_like);
	    //weather = _map(weather);
	   // console.log(weather.name);
	 //   console.log(weather.temp);
	 //   console.log(weather.pressure);
	    $("#body").html("");
    		$('#body')
    			.append(
    			  `<tr>
    				<td>`+weather.main.temp+`</td>
    				<td>`+weather.main.temp_min+`</td>
    				<td>`+weather.main.temp_max+`</td>
    				<td>`+weather.main.humidity+`</td>
    				<td>`+weather.main.pressure+`</td>
    			  </tr>`
    			);
    };

	var getWeatherByCity = function(city) {
        setCity(city);
        if (city != "") {
            $('#cinemaname').html(city);
            api.getWeatherByCity(city,table);
        }
    };
	var getFunctionsByCinemaAndDateAndMovie =  function (cinema_date,cinema_movie) {
        console.log(cinema_date);
        if (cine != "" && cinema_date != "" ) {
            api.getFunctionsByCinemaAndDateAndMovie(cine,cinema_date,cinema_movie,getSeats);
        }
    };

	return {
	    getFunctionsByCinemaAndDateAndMovie : getFunctionsByCinemaAndDateAndMovie,
		getWeatherByCity :  getWeatherByCity,
	};
})();

