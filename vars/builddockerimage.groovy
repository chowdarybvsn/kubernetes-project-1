def call(){
sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 cd /home/ansadmin'
sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45 docker image build -t $JOB_NAME:v1$BUILD_ID .'
}
