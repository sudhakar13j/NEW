package Email
def SendEmail(String from, String  to, String subject, String body)
{
echo 'demo mail'
mail bcc: '', body: body, cc: '', from: from , replyTo: '', subject: subject, to: to
echo 'Email sent successfully'
}
