-- 注意：该页面对应的前台目录为views/ldw文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202503240957140250', NULL, 'ldw_product_inventory', '/ldw/ldwProductInventoryList', 'ldw/LdwProductInventoryList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-03-24 21:57:25', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202503240957140251', '202503240957140250', '添加ldw_product_inventory', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_product_inventory:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 21:57:25', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202503240957150252', '202503240957140250', '编辑ldw_product_inventory', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_product_inventory:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 21:57:25', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202503240957150253', '202503240957140250', '删除ldw_product_inventory', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_product_inventory:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 21:57:25', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202503240957150254', '202503240957140250', '批量删除ldw_product_inventory', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_product_inventory:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 21:57:25', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202503240957150255', '202503240957140250', '导出excel_ldw_product_inventory', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_product_inventory:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 21:57:25', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202503240957150256', '202503240957140250', '导入excel_ldw_product_inventory', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_product_inventory:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 21:57:25', NULL, NULL, 0, 0, '1', 0);