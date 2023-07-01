def call(){
sh 'ssh -o StrictHostKeyChecking=no ansadmin@10.0.1.45'
sh 'scp /var/lib/jenkins/workspace/kubernetes/* ansadmin@10.0.1.45:/home/ansadmin'
}
