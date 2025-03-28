pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    withMaven(maven: 'maven') {
                        // Using bat for Windows
                        bat 'mvn clean package'
                    }
                }
            }
        }

        // Stage to clean and build the project using Maven
        stage('Clean & Build') {
            steps {
                script {
                    // Running Maven clean and install command
                    echo "Running Maven clean install"
                    bat 'mvn clean install -DskipTests' // Skipping tests for build
                }
            }
        }

        // Stage to run tests with Maven
        stage('Run Tests') {
            steps {
                script {
                    // Running tests with Maven
                    echo "Running Maven tests"
                    bat 'mvn test'
                }
            }

            post {
                success {
                    echo "Tests executed successfully!"
                }
                failure {
                    echo "Tests failed!"
                }
            }
        }

        // Stage to collect test results and publish ExtentReports (HTML)
        stage('Publish Test Results') {
            steps {
                script {
                    // Publishing ExtentReports HTML file as a report
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'htmlreports',
                        reportFiles: 'ExtentReportl',
                        reportName: 'Test API Automation Report'

                    ])
                }
            }
        }

        // Stage to deploy the application (Add your deploy steps here)
        stage('Deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                    // Add deployment steps here (e.g., uploading to a server, Docker, etc.)
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up resources'
        }
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}



