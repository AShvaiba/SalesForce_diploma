pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'GitParameterDefinition'
        choice choices: ['Chrome', 'Edge', 'Firefox'], name: 'BROWSER'
    }

    stages {
        stage('Test') {
            steps {
                // Get some code from a GitHub repository
                git branch: "$params.BRANCH", url: 'https://github.com/AShvaiba/SalesForce_diploma.git'

                // To run Maven on a Windows agent, use
                bat "mvn clean test -Dbrowser=$BROWSER"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }

            }
        }
        stage('reports') {
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