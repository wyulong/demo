package com.cc.framework.model;

import java.util.List;

public class JsTreeNode{
	
	private Long id;
	private List<JsTreeNode> children;
	//节点的 checkbox / radio 是否禁用
	private boolean chkDisabled;
	//强制节点的 checkBox / radio 的 半勾选状态
	private boolean halfCheck;
	private String icon;
	private String iconClose;
	private String iconOpen;
	private String iconSkin;
	private boolean isHidden;
	private boolean isParent;
	private String name;
	//设置节点是否隐藏 checkbox / radio 
	private boolean nocheck;
	private boolean open;
	private long pId;
	
	public long getpId() {
		return pId;
	}
	public void setpId(long pId) {
		this.pId = pId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<JsTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<JsTreeNode> children) {
		this.children = children;
	}
	public boolean isChkDisabled() {
		return chkDisabled;
	}
	public void setChkDisabled(boolean chkDisabled) {
		this.chkDisabled = chkDisabled;
	}
	public boolean isHalfCheck() {
		return halfCheck;
	}
	public void setHalfCheck(boolean halfCheck) {
		this.halfCheck = halfCheck;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIconClose() {
		return iconClose;
	}
	public void setIconClose(String iconClose) {
		this.iconClose = iconClose;
	}
	public String getIconOpen() {
		return iconOpen;
	}
	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}
	public String getIconSkin() {
		return iconSkin;
	}
	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}
	public boolean isHidden() {
		return isHidden;
	}
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	public boolean isParent() {
		return isParent;
	}
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isNocheck() {
		return nocheck;
	}
	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	
}
