def call(){
sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 cd /home/ansadmin'
sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker image tag $JOB_NAME:v1$BUILD_ID chowdarybvsn/$JOB_NAME:v1$BUILD_ID'
sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker image tag $JOB_NAME:v1$BUILD_ID chowdarybvsn/$JOB_NAME:latest'
}
