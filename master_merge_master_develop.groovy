job('example-master-merge-master-develop') {
  disabled(false)
  scm {
    git {
      remote {
        name('origin')
        url('https://bitbucket.org/rene_preissel/jenkinsbeispiel.git')
        credentials('76266ce1-3c8b-4d11-8da2-b0a4eec0716b')
      }
      branch('master')
      extensions {
         mergeOptions {
             remote('origin')
             branch('develop')
             fastForwardMode(FastForwardMergeMode.NO_FF)
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
