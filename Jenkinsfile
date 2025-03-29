pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                bat 'test'
            }

            post {
                success {
                  publishHTML([
                              allowMissing: false,
                              alwaysLinkToLastBuild: false,
                              keepAll: false,
                              reportDir: 'reports',
                              reportFiles: 'Spark.html',
                              reportName: 'ExtentReport',
                              reportTitles: '',
                              useWrapperFileDirectly: true])
                }
            }
        }
    }
}