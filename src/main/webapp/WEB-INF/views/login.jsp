<html>
<head>
<title>login</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="login.css" rel="stylesheet"/>
</head>
<body style="background:rgba(0,0,0,0.5);">
<section class="vh-50 gradient-custom" style="background:blue;">
  <div class="container py-2 h-50">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
          <form method="post">
            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">Todo-Application</h2>
              <p class="text-white-50 mb-5">create your todos</p>

              <div class="form-outline form-white mb-4">
                <input type="text" id="typeEmailX" class="form-control form-control-lg" name="name"/>
                <label class="form-label" for="typeEmailX">Name</label>
              </div>

              <div class="form-outline form-white mb-4">
                <input type="password" id="typePasswordX" class="form-control form-control-lg" name="password"/>
                <label class="form-label" for="typePasswordX">Password</label>
              </div>
              <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
              <pre style="color: red;">${error} </pre>
            </div>
          </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<br>
<br>

</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
</body>
</html>