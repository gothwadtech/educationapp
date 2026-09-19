package com.gothwad.education.data

import kotlinx.coroutines.flow.Flow

class EducationRepository(private val educationDao: EducationDao) {

    val allOfflineDrafts: Flow<List<OfflineDraft>> = educationDao.getAllOfflineDrafts()
    val allNotifications: Flow<List<NotificationItem>> = educationDao.getAllNotifications()

    suspend fun saveOfflineDraft(content: String, recipient: String = "General") {
        educationDao.insertOfflineDraft(OfflineDraft(content = content, recipient = recipient))
    }

    suspend fun deleteOfflineDraft(draft: OfflineDraft) {
        educationDao.deleteOfflineDraft(draft)
    }

    suspend fun clearAllDrafts() {
        educationDao.clearAllDrafts()
    }

    suspend fun saveNotification(title: String, message: String) {
        educationDao.insertNotification(NotificationItem(title = title, message = message))
    }

    suspend fun markNotificationAsRead(id: Int) {
        educationDao.markNotificationAsRead(id)
    }

    suspend fun deleteNotification(id: Int) {
        educationDao.deleteNotification(id)
    }

    suspend fun clearAllNotifications() {
        educationDao.clearAllNotifications()
    }
}
