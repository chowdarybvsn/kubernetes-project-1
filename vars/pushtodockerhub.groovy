def call(){
    sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker login -u chowdarybvsn -p ${dockerhub_passwd}'
    sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker image push chowdarybvsn/$JOB_NAME:v1$BUILD_ID'
    sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker image push chowdarybvsn/$JOB_NAME:latest'
}
