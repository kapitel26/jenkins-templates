listView('DVCS Book Examples') {
    description('Examples of the book')
    jobs {
       regex('example-.+')
    }

    columns {
        name()
    }
}
