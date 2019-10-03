$(document).ready(() => {

    $("#employeeForm").on("submit", (event) => {
        event.preventDefault();

        const data = {
            firstName: $('#firstName').val(),
            lastName: $('#lastName').val(),
            id: $('#id').val(),
            position: $('#position').val(),
            salary: $('#salary').val()
        }

        $.ajax({
            type: 'POST',
            url: '/api/add/employee',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            success: (response) => {
                getEmployees();
            }
        })
    });
})

function getEmployees() {
    $.ajax({
        type: 'GET',
        url: '/api/employees/all',
        success: (response) => {
            console.log(response)
        }
    })
}