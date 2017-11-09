
function addfields() {
    var p = d.createElement('details');
    p.innerHTML=' <summary>Item for promote</summary>' +
        '            <div class="input-group" style="margin-bottom: 10px;">' +
        '                <span class="input-group-addon">Item name</span>' +
        '                <input id="items'+countMain+'.name" name="items['+countMain+'].name" type="text" class="form-control"/>' +
        '            </div>' +
        '            <div class="input-group" style="margin-bottom: 10px;">' +
        '                <span class="input-group-addon">Item value</span>' +
        '                <input id="items'+countMain+'.dataSets0.itemValue" name="items['+countMain+'].dataSets[0].itemValue" type="text" class="form-control"/>' +
        '            </div>' +
        '            <div class="input-group" style="margin-bottom: 10px;">' +
        '                <span class="input-group-addon">Item remark</span>' +
        '                <input id="items'+countMain+'.dataSets0.itemRemark" name="items['+countMain+'].dataSets[0].itemRemark" type="text" class="form-control"/>' +
        '            </div>' +
        '            <div class="input-group" style="margin-bottom: 10px;">' +
        '                <span class="input-group-addon">Member</span>' +
        '                <input id="items'+countMain+'.dataSets0.members0" name="items['+countMain+'].dataSets[0].members[0]" type="text" class="form-control">' +
        '            </div>';

    myForm.appendChild(p);
    countMain++;
    return false;
}
var d = document,
    myForm = d.getElementById('mainForm'),
    butAdd = d.getElementById('addfields'),
    countMain=0;
butAdd.addEventListener('click', addfields, false);
