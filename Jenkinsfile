pipeline {
    agent any
    
    environment {
        TOMCAT_HOST = '172.23.179.44'
        TOMCAT_PORT = '22'
        TOMCAT_USER = 'aly'
        TOMCAT_PASSWORD = 'aly'
        WAR_FILE = 'JenkinsProject.war'
        TOMCAT_WEBAPPS_PATH = '/app/apache-tomcat-10.1.17/webapps'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                script {
                    // Copy the WAR file to the remote Tomcat server
                    sshagent(['alysshserver']) {
                        sh "scp -P ${TOMCAT_PORT} ${WAR_FILE} ${TOMCAT_USER}@${TOMCAT_HOST}:${TOMCAT_WEBAPPS_PATH}"
                    }

                    // Restart Tomcat to deploy the WAR
                    sshagent(['alysshserver']) {
                        sh "ssh -p ${TOMCAT_PORT} ${TOMCAT_USER}@${TOMCAT_HOST} 'cd ${TOMCAT_WEBAPPS_PATH} && rm -rf JenkinsProject && unzip ${WAR_FILE} -d JenkinsProject'"
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed!'
        }
    }
}
