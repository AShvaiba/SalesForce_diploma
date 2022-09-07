pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Test') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/AShvaiba/SalesForce_diploma.git'

                // To run Maven on a Windows agent, use
                bat "mvn clean test -Dmaven.test.failure.ignore=true -Dbrowser=$BROWSER -Dlogin.page.url=$LOGIN_PAGE_URL -Dusername=$USERNAME -Dpassword=$PASSWORD -Dapi.url=$API_URL -Dsecurity.token=$SECURITY_TOKEN -Dclient.id=$CLIENT_ID -Dclient.secret=$CLIENT_SECRET"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }

            }
        }
        stage('Reporting') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}