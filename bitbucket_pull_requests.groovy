job('example-bitbucket-pull-requests') {
  disabled(false)
  scm {
    git {
      remote {
        name('origin')
        url('http://localhost:7990/scm/git/jenkinsexample.git')
        refspec('+refs/pull-requests/*:refs/remotes/origin/pull-requests/*')
      }
      branch('origin/pull-requests/*/from')
      extensions {
         mergeOptions {
             remote('origin')
             branch('master')
             fastForwardMode(FastForwardMergeMode.NO_FF)
         }
      }
    }
  }

  triggers {
    scm('H/2 * * * *')
  }

  publishers {
    stashNotifier()
  }

  configure { node ->
    node / 'publishers' / 'org.jenkinsci.plugins.stashNotifier.StashNotifier'{
      stashServerBaseUrl('http://localhost:7990')
      credentialsId('597f7067-7ca3-42ca-ae66-50ceed73d578')
    }
  }
}
