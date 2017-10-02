<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
  <meta name="description" content="bootstrap admin template">
  <meta name="author" content="">
  <title>Not Found!</title>
  <link rel="apple-touch-icon" href="${innerPrefix}assets/images/apple-touch-icon.png">
  <link rel="shortcut icon" href="${innerPrefix}assets/images/favicon.ico">
  <!-- Stylesheets -->
  <link rel="stylesheet" href="${innerPrefix}global/css/bootstrap.min.css">
  <link rel="stylesheet" href="${innerPrefix}global/css/bootstrap-extend.min.css">
  <link rel="stylesheet" href="${innerPrefix}assets/css/site.css">
  <link rel="stylesheet" href="${innerPrefix}assets/css/waves.css">
  <link rel="stylesheet" href="${innerPrefix}assets/css/bootstrap-material-design.css">
  <!-- Plugins -->
  <link rel="stylesheet" href="${innerPrefix}global/vendor/animsition/animsition.css">
  <link rel="stylesheet" href="${innerPrefix}global/vendor/asscrollable/asScrollable.css">
  <link rel="stylesheet" href="${innerPrefix}global/vendor/switchery/switchery.css">
  <link rel="stylesheet" href="${innerPrefix}global/vendor/intro-js/introjs.css">
  <link rel="stylesheet" href="${innerPrefix}global/vendor/slidepanel/slidePanel.css">
  <link rel="stylesheet" href="${innerPrefix}global/vendor/flag-icon-css/flag-icon.css">
  <link rel="stylesheet" href="${innerPrefix}assets/examples/css/pages/login-v2.css">
  <!-- Fonts -->
  <link rel="stylesheet" href="${innerPrefix}global/fonts/web-icons/web-icons.min.css">
  <link rel="stylesheet" href="${innerPrefix}global/fonts/brand-icons/brand-icons.min.css">
  <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,300italic'>
  <!--[if lt IE 9]>
  <script src="${innerPrefix}global/vendor/html5shiv/html5shiv.min.js"></script>
  <![endif]-->
  <!--[if lt IE 10]>
  <script src="${innerPrefix}global/vendor/media-match/media.match.min.js"></script>
  <script src="${innerPrefix}global/vendor/respond/respond.min.js"></script>
  <![endif]-->
  <!-- Scripts -->
  <script src="${innerPrefix}global/vendor/breakpoints/breakpoints.js"></script>
  <script>
    Breakpoints();
  </script>
</head>
<body class="animsition page-login-v2 layout-full page-dark wthie-part-404">
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->
<style>
  body {
    background: transparent;
  }
</style>
<!-- Page -->
<div class="page" data-animsition-in="fade-in" data-animsition-out="fade-out">
  <div class="page-content">
    <div class="page-brand-info">
      <div class="brand">

        <img src="assets/images/aeb_logo.png">
      </div>

    </div>
    <div class="page-login-main animation-slide-right animation-duration-1">
      <div class="brand hidden-md-up">
        <img class="brand-img" src="assets/images/logo-blue@2x.png" alt="...">
        <h3 class="brand-text font-size-40">AEB</h3>
      </div>
      <div class="circle-404">404</div>
      <h1>Not found!</h1>

      <h2 class="font-size-24 title-404">The page you’re looking for can’t be found.</h2>


        <button class="btn btn-primary btn-block btn-raised login-btn waves-effect waves-classic" onclick="location.href='overview'" >Go back Overview</button>



    </div>
  </div>
</div>
<!-- End Page -->
<!-- Core  -->
<script src="${innerPrefix}global/vendor/babel-external-helpers/babel-external-helpers.js"></script>
<script src="${innerPrefix}global/vendor/jquery/jquery.js"></script>
<script src="${innerPrefix}global/vendor/tether/tether.js"></script>
<script src="${innerPrefix}global/vendor/bootstrap/bootstrap.js"></script>
<script src="${innerPrefix}global/vendor/animsition/animsition.js"></script>
<script src="${innerPrefix}global/vendor/mousewheel/jquery.mousewheel.js"></script>
<script src="${innerPrefix}global/vendor/asscrollbar/jquery-asScrollbar.js"></script>
<script src="${innerPrefix}global/vendor/asscrollable/jquery-asScrollable.js"></script>
<script src="${innerPrefix}global/vendor/ashoverscroll/jquery-asHoverScroll.js"></script>
<!-- Plugins -->
<script src="${innerPrefix}global/vendor/switchery/switchery.min.js"></script>
<script src="${innerPrefix}global/vendor/intro-js/intro.js"></script>
<script src="${innerPrefix}global/vendor/screenfull/screenfull.js"></script>
<script src="${innerPrefix}global/vendor/slidepanel/jquery-slidePanel.js"></script>
<script src="${innerPrefix}global/vendor/jquery-placeholder/jquery.placeholder.js"></script>
<!-- Scripts -->
<script src="${innerPrefix}global/js/State.js"></script>
<script src="${innerPrefix}global/js/Component.js"></script>
<script src="${innerPrefix}global/js/Plugin.js"></script>
<script src="${innerPrefix}global/js/Base.js"></script>
<script src="${innerPrefix}global/js/Config.js"></script>
<script src="${innerPrefix}assets/js/Section/Menubar.js"></script>
<script src="${innerPrefix}assets/js/Section/GridMenu.js"></script>
<script src="${innerPrefix}assets/js/Section/Sidebar.js"></script>
<script src="${innerPrefix}assets/js/Section/PageAside.js"></script>
<script src="${innerPrefix}assets/js/Plugin/menu.js"></script>
<script src="${innerPrefix}global/js/config/colors.js"></script>
<script src="${innerPrefix}assets/js/config/tour.js"></script>
<script>
  Config.set('assets', 'assets');
</script>
<!-- Page -->
<script src="${innerPrefix}assets/js/Site.js"></script>
<script src="${innerPrefix}assets/js/waves.js"></script>
<script src="${innerPrefix}global/js/Plugin/asscrollable.js"></script>
<script src="${innerPrefix}global/js/Plugin/slidepanel.js"></script>
<script src="${innerPrefix}global/js/Plugin/switchery.js"></script>
<script src="${innerPrefix}global/js/Plugin/jquery-placeholder.js"></script>
<script>
  (function(document, window, $) {
    'use strict';
    var Site = window.Site;
    $(document).ready(function() {
      Site.run();
    });
  })(document, window, jQuery);
</script>
</body>
</html>