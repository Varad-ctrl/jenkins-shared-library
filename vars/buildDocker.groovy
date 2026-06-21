def call(String imageName, String dockerfilePath) {
    sh "docker build -t ${imageName}:latest ${dockerfilePath}"
}
