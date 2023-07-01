@Library( "my_sh_lib") _
node{
    stage('checkout') {
        git 'https://github.com/chowdarybvsn/kubernetes-project-1.git'
    }
    stage('sending docker file to ansible server') {
        sshagent(['jenkinsssh']) {
         
        }
    }    
    stage('creating docker image') {
        sshagent(['jenkinsssh']){
            sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 cd /home/ansadmin'
            sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker image build -t $JOB_NAME:v1$BUILD_ID .'
        }
    }
    stage('docker image tagging') {
        sshagent(['jenkinsssh']){
            sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 cd /home/ansadmin'
            sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker image tag $JOB_NAME:v1$BUILD_ID chowdarybvsn/$JOB_NAME:v1$BUILD_ID'
            sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker image tag $JOB_NAME:v1$BUILD_ID chowdarybvsn/$JOB_NAME:latest'
        }
    }
    stage('docker image upload to docker hub') {
        sshagent(['jenkinsssh']){
            withCredentials([string(credentialsId: 'dockerhub_passwd', variable: 'dockerhub_passwd')]) {
                            sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker login -u chowdarybvsn -p ${dockerhub_passwd}'
                            sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker image push chowdarybvsn/$JOB_NAME:v1$BUILD_ID'
                            sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker image push chowdarybvsn/$JOB_NAME:latest'
           }
        }
    }
}