node {
    stage('SCM checkout') {
        git branch: 'master', credentialsId: 'git-creds', url: 'https://github.com/thaiDev1997/jenkins-docker.git'
    }
	stage('Mvn Package') {
		def mvnHome = tool name: 'maven-3', type: 'maven'
		def mvnCMD = "${mvnHome}/bin/mvn"
		bat "${mvnCMD} clean package"
	}
	stage('Build Docker Image') {
		// don't run remove image in the first build, it can appear a error 'no such image'
		bat "docker rmi springboot-jenkins-image -f"
		bat "docker build -t springboot-jenkins-image -f ./Dockerfile ."
	}
	stage('Run Docker Container') {
		// don't run remove container in the first build, it can appear a error 'no such container'
		bat "docker rm springboot-jenkins-container -f || true"
		bat "docker run --name springboot-jenkins-container -p 18000:8095 --link jpa_mysql:mysql -it -d springboot-jenkins-image"
	}
}
