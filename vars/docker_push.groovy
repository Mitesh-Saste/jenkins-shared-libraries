def call(String Project, String ImageTag, String dockerHubUser){
  withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'DockerHubPass', usernameVariable: 'DockerHubUser')]) {
      sh "docker login -u ${DockerHubUser} -p ${DockerHubPass}"
  }
  sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
