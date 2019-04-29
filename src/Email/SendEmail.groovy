package Email
def SendEmail(String from, String  to, String subject)
{
echo 'demo mail'
mail bcc: '', body: 'Demo', cc: '', from: from , replyTo: '', subject: subject, to: to
echo 'Email sent successfully'
}
