@Library( "my_sh_lib") _
node{
    stage('checkout') {
        git 'https://github.com/chowdarybvsn/kubernetes-project-1.git'
    }
    stage('sending docker file to ansible server') {
        sshagent(['jenkinsssh']) {
           sendingdockerfile()
        }
    }    
    stage('creating docker image') {
        sshagent(['jenkinsssh']){
            builddockerimage()
        }
    }
    stage('docker image tagging') {
        sshagent(['jenkinsssh']){
            imagetagging()
        }
    }
    stage('docker image upload to docker hub') {
        sshagent(['jenkinsssh']){
            withCredentials([string(credentialsId: 'dockerhub_passwd', variable: 'dockerhub_passwd')]) {
                        pushtodockerhub()
           }
        }
    }
}