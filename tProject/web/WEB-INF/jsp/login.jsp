<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
  <title>Login</title>

  <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,300italic'>
  <link rel="stylesheet" href="assets/style.css">
  <![endif]-->
  <!-- Scripts -->
</head>

<![endif]-->
<div style="width: 100%; height: 100%; display: flex;
justify-content: center; align-items: center">
  <div style="display: flex; flex-direction: column">
    <form style="display: flex; flex-direction: column" action="/api/login" method="post">
      <input name="username" type="text">
      <input name="password" type="password">
      <button type="submit">Login</button>
    </form>
  </div>
</div>
</body>
</html>