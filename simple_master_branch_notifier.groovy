job('example-simple-master-branch-notifier') {
  disabled(false)
  scm {
    git {
      remote {
        name('origin')
        url('http://localhost:7990/scm/git/jenkinsexample.git')
      }
      branch('master')
    }
  }

  triggers {
    scm('') //leave empty for commitNotifier
  }
}
