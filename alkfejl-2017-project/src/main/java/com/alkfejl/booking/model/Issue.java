package com.alkfejl.booking.model;

@Entity
@Table(name = "ISSUES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Issue extends BaseEntity {

    @JoinColumn
    @ManyToOne(targetEntity = User.class)
    private User user;

    @Column(nullable = false)
    private Timestamp timestamp;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String description;

    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = IssueMessage.class)
    private List<IssueMessage> messages;

    public enum Status {
        ADDED, READY, ONGOING
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<IssueMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<IssueMessage> messages) {
		this.messages = messages;
	}
    
    
}

