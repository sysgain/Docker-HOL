node
{
    docker.withRegistry('https://dtrlb-rt5k7cqehguoy.westus.cloudapp.azure.com/','dtr-login-user0'){
       // dtr-login is a login ID in credentials 
        stage "syncing files"
        git 'https://github.com/sample/sample-app.git'

        stage "Building and pushing Vote Image"
        def vote_img = docker.build('admin/voting-app-vote','./vote').push('latest')

        stage "Building and pushing Worker Image"
        def worker_img = docker.build('admin/voting-app-worker','./worker').push('latest')

        stage "Building and pushing Result Image"
        def result_img = docker.build('admin/voting-app-result','./result').push('latest')
    }
}
