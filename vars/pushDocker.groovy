def call(String imageName, String dockerUser) {

    withCredentials([
        usernamePassword(
            credentialsId: 'docker-hub-cred',
            usernameVariable: 'USER',
            passwordVariable: 'PASS'
        )
    ]) {

        sh """
        echo \$PASS | docker login -u \$USER --password-stdin

        docker tag ${imageName}:latest ${dockerUser}/${imageName}:latest

        docker push ${dockerUser}/${imageName}:latest
        """
    }
}
