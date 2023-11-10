const report = require('multiple-cucumber-html-reporter');

report.generate({
    jsonDir: './test/report/',
    reportPath: './test/report/',
    openReportInBrowser: true,
    metadata:{
        browser: {
            name: 'chrome',
            version: '96.0.4664.45'
        },
        device: 'Local test machine',
        platform: {
            name: 'windows',
            version: '21H2'
        }
    },
    customData: {
        title: 'Run info',
        data: [
            {label: 'Project', value: 'Retos-Banco-Cuscatlan'},
            {label: 'Release', value: ''},
            {label: 'Cycle', value: ''},
            {label: 'Execution Start Time', value: ''},
            {label: 'Execution End Time', value: ''}
        ]
    }
});