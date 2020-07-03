<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Estate Management System</title>
    <meta content="" name="descriptison">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
    <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="assets/css/style.css" rel="stylesheet">

    <!-- =======================================================
  * Template Name: Sailor - v2.0.0
  * Template URL: https://bootstrapmade.com/sailor-free-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

    <!-- ======= Header ======= -->
    <header id="header" class="fixed-top header-inner-pages">
        <div class="container d-flex align-items-center">

            <!-- <h1 class="logo"><a href="index.html">Sailor</a></h1>-->
            <!-- Uncomment below if you prefer to use an image logo -->
            <a href="index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>

            <nav class="nav-menu d-none d-lg-block">

                <ul>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="createac.php">Create Account</a></li>
                    <li class="active"><a href="checkrecord.php">Check Booking Record</a></li>
                </ul>

            </nav><!-- .nav-menu -->

        </div>
    </header><!-- End Header -->

    <main id="main">

        <!-- ======= Breadcrumbs ======= -->
        <section id="breadcrumbs" class="breadcrumbs">
            <div class="container">

                <div class="d-flex justify-content-between align-items-center">
                    <h2>Check Booking Record</h2>
                    <ol>
                        <li><a href="index.html">Home</a></li>
                        <li>Check Booking Record</li>
                    </ol>
                </div>
            </div>
        </section><!-- End Breadcrumbs -->

        <!-- ======= Services Section ======= -->

        <section id="features" class="features">
            <div class="container">

                    <div class="tab-content">
                        <div class="tab-pane active show" id="tab-1">
                            <div class="row">
                                <p class="font-italic"></p>
                                <?php 
$conn = mysqli_connect("127.0.0.1", "root", "", "fyp")
or die(mysqli_connect_error());
?>
                                <table width="100%" border="1" class="table">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">Booking ID</th>
                                            <th scope="col">Username</th>
                                            <th scope="col">Facilities Type</th>
                                            <th scope="col">Date</th>
                                            <th scope="col">Time Period</th>
                                            <th scope="col">Status</th>
                                        </tr>
                                    </thead>
                                    <?php
            $sql = "SELECT * FROM booking;";
            $rs = mysqli_query($conn, $sql)
            or die(mysqli_error($conn));
 
            while ($rc = mysqli_fetch_assoc($rs)) {
        ?>
 <tr>
                                        <td><?php echo $rc['BookingID'] ?></td>
                                        <td><?php echo $rc['username']; ?></td>
                                        <td><?php echo $rc['Type']; ?></td>
                                        <td><?php echo $rc['Date']; ?></td>
                                        <td><?php echo $rc['Period']; ?></td>
                                        <td><?php echo $rc['Status']; ?></td>
                                    </tr>


<?php
    };
            mysqli_free_result($rs);
            mysqli_close($conn);
        ?>

                                </table>

                            </div>
                        </div>
                    </div>
                </div>
        </section><!-- End Features Section -->

    </main><!-- End #main -->

    <!-- ======= Footer ======= -->
    <footer id="footer">
        <div class="footer-top">
            <div class="container">
                <div class="row">

                    <div class="col-lg-3 col-md-6">
                        <div class="footer-info">
                            <h3>Estate Management System</h3>
                            <p>
                                A108 Adam Street, HK<br><br>
                                <strong>Phone:</strong> +852 12345678<br>
                                <strong>Email:</strong> info@ems.com<br>
                            </p>
                        </div>
                    </div>


                    <div class="col-lg-2 col-md-6 footer-links">
                        <h4>Useful Links</h4>
                        <ul>
                            <li><i class="bx bx-chevron-right"></i> <a href="index.html">Home</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="createac.php">Create Account</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="checkrecord.php">Check Booking Record</a></li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>

    </footer><!-- End Footer -->

    <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

    <!-- Vendor JS Files -->
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
    <script src="assets/vendor/php-email-form/validate.js"></script>
    <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
    <script src="assets/vendor/venobox/venobox.min.js"></script>
    <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
    <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>

    <!-- Template Main JS File -->
    <script src="assets/js/main.js"></script>

</body>


</html>
