<html>
    <body>
    <!-- page -> request -> session -> application(ServletContext) -->
        \${userObject.name} : ${userObject.name}
        \${applicationScope['scopedTarget.user'.name} : ${applicationScope['scopedTarget.user'].name}
    </body>
</html>