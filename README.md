# ReckonINGMultiThreads


<b>HeroKu API (cloud) - Active</b>
<li>GetBank list:</li>
https://my-reckoning.herokuapp.com/ReckonINGExample/getBanks

<li>Get all accounts for user iamben</li>
https://my-reckoning.herokuapp.com/ReckonINGExample/getMyAccounts?user_name=iamben

<li>Get all accounts for user iamsam</li>
https://my-reckoning.herokuapp.com/ReckonINGExample/getMyAccounts?user_name=iamsam

<li>Get balance for user iamben, bank_id = ING(at02-1465--01), Account name=iamben_ing</li>
https://my-reckoning.herokuapp.com/ReckonINGExample/getAccountById?user_name=iamben&bank_id=at02-1465--01&account=iamben_ing

<li>Get balance for user iamsam, bank_id = Santander(at02-0182--01), Account name=iamsam_spain</li>
https://my-reckoning.herokuapp.com/ReckonINGExample/getAccountById?user_name=iamsam&bank_id=at02-0182--01&account=iamsam_spain

<li>Transfer 10 dollar from Sam(Santander) to ben(ING)</li>
https://my-reckoning.herokuapp.com/ReckonINGExample/createTransaction/iamsam?frombank_id=at02-0182--01&fromid=iamsam_spain&amount=10&tobank_id=at02-1465--01&toid=iamben_ing

<li>Check Transaction history for account iamben in ING bank, under user iamben</li>
https://my-reckoning.herokuapp.com/ReckonINGExample/getTransactionHistoryById?user_name=iamben&bank_id=at02-1465--01&account=iamben_ing

<li>Check Transaction history for account iamsam in Santander bank, under user iamsam</li>
https://my-reckoning.herokuapp.com/ReckonINGExample/getTransactionHistoryById?user_name=iamsam&bank_id=at02-0182--01&account=iamsam_spain

<li>Check ALL Transaction history of user iamsam (sorted by completion datetime in descendent)</li>
https://my-reckoning.herokuapp.com/ReckonINGExample/getMyTransactionHistory?user_name=iamsam

<br/>
<br/>

<b>Loan Calculator:</b>
<br/>

https://my-reckoning.herokuapp.com/ReckonINGExample/loan-calculator?loanAmount=500000&numYears=15&currentAge=35&totalMonthlyDebt=3600&totalMonthlyIncome=8888&LoanType=ING
<br/>


https://my-reckoning.herokuapp.com/ReckonINGExample/loan-calculator?loanAmount=500000&numYears=15&currentAge=35&totalMonthlyDebt=3600&totalMonthlyIncome=8888&LoanType=SCB
<br/>


https://my-reckoning.herokuapp.com/ReckonINGExample/loan-calculator?loanAmount=500000&numYears=15&currentAge=35&totalMonthlyDebt=3600&totalMonthlyIncome=8888&LoanType=OCBC
<br/>


https://my-reckoning.herokuapp.com/ReckonINGExample/loan-calculator?loanAmount=500000&numYears=15&currentAge=35&totalMonthlyDebt=3600&totalMonthlyIncome=8888&LoanType=CITI
<br/>


https://my-reckoning.herokuapp.com/ReckonINGExample/loan-calculator?loanAmount=500000&numYears=15&currentAge=35&totalMonthlyDebt=3600&totalMonthlyIncome=8888&LoanType=HSBC
<br/>




<li>short name mapping</li><br/>
BanksShortName.put("at02-1465--01", "Netherlands Bank");<br/>
BanksShortName.put("at02-0075--01", “Banco popular”);<br/>
BanksShortName.put("at02-0182--01", "Spanish Bank");<br/>
BanksShortName.put("at02-0019--01", "German Bank");<br/>
BanksShortName.put("at02-0073--01", “Open Bank”);v
BanksShortName.put("at03-0019", "German Bank");<br/>
BanksShortName.put("at02-0049--01", “Santander Bank");<br/>

<li>users: iamsam (account of Sam)   password: Bennett0910!</li><br/>
Account list:<br/>
iamsam_ing   "at02-1465--01", "Netherlands Bank"<br/>
iamsam_spain  "at02-0182--01", "Spanish Bank"<br/>
iamsam_db   "at02-0019--01", "German Bank"<br/>
iamsam_san   "at02-0049--01", “Santander Bank"<br/>


<li>users: iamben (account of Ben)   password: Bennett0910!</li><br/>
Account list:<br/>
iamben_ing   "at02-1465--01", "Netherlands Bank"<br/>
iamben_db   "at02-0019--01", "German Bank" (GBP account)<br/>
iamben_open   "at02-0073--01", “Open Bank”<br/>
iamben_pop  "at02-0075--01", “Banco popular”<br/>

