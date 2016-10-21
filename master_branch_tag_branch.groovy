job('example-master-branch-tag-branch') {
  disabled(false)
  scm {
    git {
      remote {
        name('origin')
        url('https://bitbucket.org/rene_preissel/jenkinsbeispiel.git')
        credentials('76266ce1-3c8b-4d11-8da2-b0a4eec0716b')
      }
      branch('master')
    }
  }

  triggers {
    scm('H/2 * * * *')
  }

  publishers {
    git {
      pushOnlyIfSuccess(true)
      tag('origin', 'build/$BUILD_NUMBER') {
        create(true)
      }
      branch('origin', 'refs/heads/build/latest')
    }
  }
}
