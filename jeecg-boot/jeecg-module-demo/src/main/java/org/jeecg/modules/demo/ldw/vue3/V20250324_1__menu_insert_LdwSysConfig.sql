-- 注意：该页面对应的前台目录为views/ldw文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025032410382810360', NULL, 'ldw_sys_config', '/ldw/ldwSysConfigList', 'ldw/LdwSysConfigList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-03-24 22:38:36', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025032410382820361', '2025032410382810360', '添加ldw_sys_config', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_sys_config:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 22:38:36', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025032410382820362', '2025032410382810360', '编辑ldw_sys_config', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_sys_config:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 22:38:36', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025032410382820363', '2025032410382810360', '删除ldw_sys_config', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_sys_config:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 22:38:36', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025032410382820364', '2025032410382810360', '批量删除ldw_sys_config', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_sys_config:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 22:38:36', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025032410382820365', '2025032410382810360', '导出excel_ldw_sys_config', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_sys_config:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 22:38:36', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025032410382820366', '2025032410382810360', '导入excel_ldw_sys_config', NULL, NULL, 0, NULL, NULL, 2, 'ldw:ldw_sys_config:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-24 22:38:36', NULL, NULL, 0, 0, '1', 0);