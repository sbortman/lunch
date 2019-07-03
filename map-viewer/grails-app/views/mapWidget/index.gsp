<html>
<head>
    <meta name="layout" content="main">
    <asset:stylesheet src="mapWidget.css"/>
</head>
<body>
<div class="content">
    <h1>Map Widget</h1>
    <div id="map"></div>
</div>
<asset:javascript src="mapWidget.js"/>
<asset:script>
    $(document).ready(function() {
        MapWidget.init();
    } );
</asset:script>
<asset:deferredScripts/>
</body>
</html>