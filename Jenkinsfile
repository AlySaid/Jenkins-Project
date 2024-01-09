pipeline {
    agent any
 
    stages {
        stage('Build') {
            steps {
                // Build your Spring Boot application using Maven
                echo 'Runing Build Automation'
                sh 'mvn clean package'
            }
        }



        stage('Deploy') {
             when {
                branch 'main'
            }
            steps {
                //Use below line to ask before proceeding to deploy, you need to hoover on deploy box to proceed.
               
                // Use the Publish Over SSH plugin to transfer the JAR file to the deployment server
                sshPublisher(publishers: [
                    sshPublisherDesc(configName: 'alysshserver', transfers: [
                        sshTransfer(execCommand: '' ,
                                    execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/app/apache-tomcat-10.1.17/webapps/', remoteDirectorySDF: false, removePrefix: 'target', sourceFiles: 'target/*.war')
                    ])
                ])
            }
        }

       


    }
}
