def SentEmail(from, to, subject)
{
echo 'demo mail'
mail bcc: '', body: 'Demo', cc: from, from: from , replyTo: '', subject: subject, to: to
echo 'email sent successfully'
}
