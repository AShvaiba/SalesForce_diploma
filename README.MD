# **SalesForce testing checklist**

### UI tests
#### Accounts:
1. Creation of new account with main info specified
2. Creation of new account with only required info specified
3. Creation of new account with empty fields

#### Contacts:
1. Creation of new contact with main info specified
2. Creation of new contact with only required info specified
3. Creation of new contact with empty fields


### API tests
##### Leads:
1. Creation of new lead with main info specified
2. Creation of new lead with only required info specified
3. Update main fields of random lead
4. Creation of new lead with empty fields
5. Delete random lead

___

# Steps for tests running
1. Register your account here: https://developer.salesforce.com/signup (dev account is needed to make API requests)
2. Activate your account using email. Perform logout, then login and confirm that you do not want to confirm your mobile phone.
3. To avoid email confirming when login go to Setup > Network Access and set your IP address
4. Register your API: https://www.sfdcstop.com/2019/01/how-to-connect-to-salesforce-with.html

#### For local test run open src/maim/resources/config.properties and set following properties
   - login.page.url=<your_login_page_url>
   - username=<email_you_used_when_register_account>
   - password=<password_you_used_when_register_account>
   - api.url=<your_api_url>
   - security.token=<corresponding_value_from_p4>
   - client.id=<corresponding_value_from_p4>
   - client.secret=<corresponding_value_from_p4>
   
To run tests locally you can use just the comand 'mvn clean test'


#### For running tests via jenkins:
1. Create pipeline and set option 'This project is parametrised' to true
2. Add following parameters (Default Values for String Parameters are same as for corresponding parameters for local run - see above):
   - Git Parameter: Name - BRANCH, Parameter Type - Branch, Default Value - origin/master
   - Choice Parameter: Name - BROWSER, Choices: Chrome, Firefox, Edge
   - String Parameter: Name - LOGIN_PAGE_URL, Default Value - see above
   - String Parameter: Name - USERNAME, Default Value - see above
   - String Parameter: Name - PASSWORD, Default Value - see above
   - String Parameter: Name - API_URL, Default Value - see above
   - String Parameter: Name - SECURITY_TOKEN, Default Value - see above
   - String Parameter: Name - CLIENT_ID, Default Value - see above
   - String Parameter: Name - CLIENT_SECRET, Default Value - see above
3. In definition select 'Pipeline script for SCM'
4. In SCM select Git
5. Set https://github.com/AShvaiba/SalesForce_diploma.git in 'Repository URL' field
6. Add your Personal access token to credentials. If you do not have any create it: in your GitHub account go to Settings > Developer Settings > Personal access tokens
7. Add Branch to build - specify $BRANCH as Branch Specifier

After performing described steps you are able to use 'Build with Parameters' for your pipeline with needed parameters.
