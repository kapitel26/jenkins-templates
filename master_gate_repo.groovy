job('example-master-gate-repo') {
  disabled(false)
  scm {
    git {
      remote {
        name('origin')
        url('https://bitbucket.org/rene_preissel/jenkinsbeispiel.git')
        credentials('76266ce1-3c8b-4d11-8da2-b0a4eec0716b')
      }
      remote {
        name('gate')
        url('https://bitbucket.org/rene_preissel/jenkinsbeispielgate.git')
        credentials('76266ce1-3c8b-4d11-8da2-b0a4eec0716b')
      }
      branch('gate/*/master')
      extensions {
         mergeOptions {
             remote('origin')
             branch('master')
         }
      }
      configure { node ->
        node / 'extensions' / 'hudson.plugins.git.extensions.impl.ChangelogToBranch' / 'options' {
          compareRemote('origin')
          compareTarget('master')
        }
      }
    }
  }

  triggers {
    scm('') //leave empty for commitNotifier
  }

  publishers {
    git {
      pushOnlyIfSuccess(true)
      pushMerge(true)
    }
  }
}
