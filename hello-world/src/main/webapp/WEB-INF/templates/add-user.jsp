<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <title>add-product</title>
  </head>
  <body class="container-sm d-flex flex-column align-items-center">
  	<nav class="nav py-2">
  		<c:url var="toHome" value="/home"/>
		  <a class="nav-link" href="${toHome}">Home</a>
		  <c:url var="toCatalog" value="/catalog"/>
		  <a class="nav-link" href="${toCatalog}">Catalog</a>
		  <c:url var="toCart" value="/cart"/>
		  <a class="nav-link" href="${toCart}">Cart</a>
		</nav>
		
		<c:url var="submitURL" value="/users/add" />
		<form action="${submitURL}" class="mt-5" method="POST">
		  <div class="row mb-3">
		    <label for="inputName" class="col-sm-2 col-form-label">Name</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputName" name="name" placeholder="...">
		    </div>
		  </div>
		  <div class="row mb-3">
		    <label for="inputRole" class="col-sm-2 col-form-label">Role</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputRole" name="role" placeholder="...">
		    </div>
		  </div>
		  <div class="row mb-3">
		    <label for="inputPass" class="col-sm-2 col-form-label">Pass</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="inputPass" name="password" placeholder="...">
		    </div>
		  </div>
		  <button type="submit" class="btn btn-primary mt-2">Submit</button>
		</form>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
  </body>
</html>
