<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
div {
	border: 1px solid black;
	height: 150px;
}

.mapArea{
	height:550px;
}
</style>

<link href="css/bootstrap.min.css" rel="stylesheet" />
<title>map-3-1</title>
</head>
<script src="http://maps.googleapis.com/maps/api/js">
	
</script>

<script>
	var myCenter = new google.maps.LatLng(51.508742, -0.120850);

	function initialize() {
		var mapProp = {
			center : myCenter,
			zoom : 5,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};

		var map = new google.maps.Map(document.getElementById("googleMap"),
				mapProp);

		var marker = new google.maps.Marker({
			position : myCenter,
		});

		marker.setMap(map);

		var infowindow = new google.maps.InfoWindow({
			content : "Hello World!~~"
		});

		google.maps.event.addListener(marker, 'click', function() {
			infowindow.open(map, marker);
		});
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>

<body>

	<div>
		<header> </header>
		<div class="row"  >
			<div class="mapArea col-md-2" ></div>
			
			<div  class="mapArea col-md-8" id="googleMap" ></div>
			
			<div class="mapArea col-md-2"></div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6"></div>
			<div class="col-md-3"></div>

		</div>

		<footer class="row">
			<div class="col-md-2"></div>
			<figure class="col-md-2">
				<a href="main-2.html"><img src="main" class="img-circle"></a>
			</figure>
			<figure class="col-md-2">
				<a href="canldern-3-1.html"><img src="canldern"
					class="img-circle"></a>
			</figure>
			<figure class="col-md-2">

				<a href="photo-3-1.html"><img src="photo" class="img-circle"></a>
			</figure>
			<figure class="col-md-2">
				<a href="map-3-1.html"><img src="map" class="img-circle">
				</a>
			</figure>
		</footer>
	</div>
</body>
</html>
