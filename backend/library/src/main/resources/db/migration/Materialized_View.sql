create view book_view as
    select b.bookId, b.available_copies
        from Book b