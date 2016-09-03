package com.cc.framework.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_message")
public class SysMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modify_date")
    private Date modifyDate;

    private String ip;

    @Column(name = "is_draft")
    private Boolean isDraft;

    @Column(name = "receiver_delete")
    private Boolean receiverDelete;

    @Column(name = "receiver_read")
    private Boolean receiverRead;

    @Column(name = "sender_delete")
    private Boolean senderDelete;

    @Column(name = "sender_read")
    private Boolean senderRead;

    private String title;

    @Column(name = "for_message")
    private Long forMessage;

    private Long receiver;

    private Long sender;

    private String content;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return modify_date
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * @param modifyDate
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return is_draft
     */
    public Boolean getIsDraft() {
        return isDraft;
    }

    /**
     * @param isDraft
     */
    public void setIsDraft(Boolean isDraft) {
        this.isDraft = isDraft;
    }

    /**
     * @return receiver_delete
     */
    public Boolean getReceiverDelete() {
        return receiverDelete;
    }

    /**
     * @param receiverDelete
     */
    public void setReceiverDelete(Boolean receiverDelete) {
        this.receiverDelete = receiverDelete;
    }

    /**
     * @return receiver_read
     */
    public Boolean getReceiverRead() {
        return receiverRead;
    }

    /**
     * @param receiverRead
     */
    public void setReceiverRead(Boolean receiverRead) {
        this.receiverRead = receiverRead;
    }

    /**
     * @return sender_delete
     */
    public Boolean getSenderDelete() {
        return senderDelete;
    }

    /**
     * @param senderDelete
     */
    public void setSenderDelete(Boolean senderDelete) {
        this.senderDelete = senderDelete;
    }

    /**
     * @return sender_read
     */
    public Boolean getSenderRead() {
        return senderRead;
    }

    /**
     * @param senderRead
     */
    public void setSenderRead(Boolean senderRead) {
        this.senderRead = senderRead;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return for_message
     */
    public Long getForMessage() {
        return forMessage;
    }

    /**
     * @param forMessage
     */
    public void setForMessage(Long forMessage) {
        this.forMessage = forMessage;
    }

    /**
     * @return receiver
     */
    public Long getReceiver() {
        return receiver;
    }

    /**
     * @param receiver
     */
    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    /**
     * @return sender
     */
    public Long getSender() {
        return sender;
    }

    /**
     * @param sender
     */
    public void setSender(Long sender) {
        this.sender = sender;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}