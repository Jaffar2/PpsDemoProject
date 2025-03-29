pipeline {
    agent any

    environment {
        // Define Maven home path, adjust according to your Jenkins setup if necessary
        MAVEN_HOME = tool name: 'M2_HOME', type: 'ToolLocation'
        PATH = "${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        // Stage to clean and build the project using Maven
        stage('Clean & Build') {
            steps {
                script {
                    // Running Maven clean and install command
                    echo "Running Maven clean install"
                    sh 'mvn clean install -DskipTests' // Skipping tests for build
                }
            }
        }

        // Stage to run tests with Maven
        stage('Run Tests') {
            steps {
                script {
                    // Running tests with Maven
                    echo "Running Maven tests"
                    sh 'mvn test'
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
                        reportDir: 'target/extent-reports',  // Directory containing your ExtentReports HTML files
                        reportFiles: 'TestReport',           // Change this to your specific HTML report file if different
                        reportName: 'ExtentReport',
                        reportTitles: '',
                        useWrapperFileDirectly: true
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

