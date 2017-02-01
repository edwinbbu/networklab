#!"C:\xampp\perl\bin\perl.exe"
use CGI;

my $q=new CGI;
my $nam=$q->param("name");
my $age=$q->param("age");
my $gender=$q->param("gender");
my $email=$q->param("email");
my $address=$q->param("address");
print "Content-type: text/html \n\n",
"<html>",
"<title></title><body><p>Name:$nam</br>Age:$age</br>gender:$gender</br>email:$email</br>address:$address</p></body></html>"
