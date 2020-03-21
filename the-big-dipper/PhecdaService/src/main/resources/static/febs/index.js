layui.extend({
    febs: 'lay/modules/febs',
    validate: 'lay/modules/validate'
}).define(['febs', 'conf'], function (exports) {
    layui.febs.initPage();
    exports('index', {});
});