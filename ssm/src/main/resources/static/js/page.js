(function() {
    "use strict";
    $("#page").pagination({
        pageIndex: 1,
        pageSize: 2,
        total: 3,
        debug: true,
        showInfo: true,
        showJump: true,
        showPageSizes: true,
        pageElementSort: ['$page', '$size', '$jump', '$info']
    });
})(jQuery);
